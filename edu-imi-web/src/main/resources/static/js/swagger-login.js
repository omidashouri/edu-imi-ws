(function () {
    var form = document.querySelector("form");
    var button = document.getElementById("login-button");
    var captchaImage = document.getElementById("captcha-image");
    var captchaInput = document.getElementById("captcha");

    if (form && button) {
        window.addEventListener("pageshow", function () {
            button.disabled = false;
        });
        form.addEventListener("submit", function () {
            window.setTimeout(function () {
                button.disabled = true;
            }, 0);
        });
    }

    if (captchaImage) {
        captchaImage.addEventListener("click", function () {
            var base = captchaImage.getAttribute("src").split("?")[0];
            captchaImage.setAttribute("src", base + "?t=" + Date.now());
            if (captchaInput) {
                captchaInput.value = "";
                captchaInput.focus();
            }
        });
    }
})();
