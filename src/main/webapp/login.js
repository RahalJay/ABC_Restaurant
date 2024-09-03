document.addEventListener('DOMContentLoaded', function () {
    const loginForm = document.getElementById("login-form");
    const cancelButton = document.getElementById("cancel-btn");

    // Handle form submission
    loginForm.addEventListener("submit", function (event) {
        event.preventDefault();
        // Redirect to the home page after clicking "Login"
        window.location.href = "home.html";
    });

    // Handle cancel button click
    cancelButton.addEventListener("click", function () {
        // Clear the form inputs
        loginForm.reset();
    });
});
