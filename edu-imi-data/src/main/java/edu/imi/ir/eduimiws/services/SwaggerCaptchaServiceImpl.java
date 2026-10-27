package edu.imi.ir.eduimiws.services;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;

@Service
public class SwaggerCaptchaServiceImpl implements SwaggerCaptchaService {

    private static final String SESSION_KEY = "SWAGGER_CAPTCHA_CODE";
    private static final String ALPHABET = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789";
    private static final int CODE_LENGTH = 5;
    private static final int WIDTH = 160;
    private static final int HEIGHT = 48;

    private final SecureRandom random = new SecureRandom();

    @Override
    public byte[] createCaptchaPng(HttpSession session) throws IOException {
        String code = randomCode();
        session.setAttribute(SESSION_KEY, code);
        return toPng(drawImage(code));
    }

    @Override
    public boolean validateAndClear(HttpSession session, String submitted) {
        Object stored = session.getAttribute(SESSION_KEY);
        session.removeAttribute(SESSION_KEY);
        if (stored == null || submitted == null || submitted.isBlank()) {
            return false;
        }
        return stored.toString().equalsIgnoreCase(submitted.trim());
    }

    private String randomCode() {
        StringBuilder sb = new StringBuilder(CODE_LENGTH);
        for (int i = 0; i < CODE_LENGTH; i++) {
            sb.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }
        return sb.toString();
    }

    private BufferedImage drawImage(String code) {
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        try {
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setColor(new Color(246, 243, 236));
            g.fillRect(0, 0, WIDTH, HEIGHT);

            for (int i = 0; i < 28; i++) {
                g.setColor(new Color(random.nextInt(180), random.nextInt(180), random.nextInt(180), 90));
                int x = random.nextInt(WIDTH);
                int y = random.nextInt(HEIGHT);
                g.fillOval(x, y, 2 + random.nextInt(4), 2 + random.nextInt(4));
            }

            for (int i = 0; i < 4; i++) {
                g.setColor(new Color(random.nextInt(120), random.nextInt(120), random.nextInt(120), 140));
                g.drawLine(random.nextInt(WIDTH), random.nextInt(HEIGHT),
                        random.nextInt(WIDTH), random.nextInt(HEIGHT));
            }

            g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 28));
            int x = 14;
            for (int i = 0; i < code.length(); i++) {
                g.setColor(new Color(6 + random.nextInt(40), 32 + random.nextInt(50), 63 + random.nextInt(40)));
                double angle = (random.nextDouble() - 0.5) * 0.45;
                g.rotate(angle, x + 8, HEIGHT / 2.0);
                g.drawString(String.valueOf(code.charAt(i)), x, 34 + random.nextInt(5));
                g.rotate(-angle, x + 8, HEIGHT / 2.0);
                x += 28;
            }
        } finally {
            g.dispose();
        }
        return image;
    }

    private byte[] toPng(BufferedImage image) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ImageIO.write(image, "png", out);
        return out.toByteArray();
    }
}
