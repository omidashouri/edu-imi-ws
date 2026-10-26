(function () {
    var form = document.querySelector("form");
    var button = document.getElementById("login-button");
    if (!form || !button) {
        return;
    }
    window.addEventListener("pageshow", function () {
        button.disabled = false;
    });
    form.addEventListener("submit", function () {
        window.setTimeout(function () {
            button.disabled = true;
        }, 0);
    });
})();
