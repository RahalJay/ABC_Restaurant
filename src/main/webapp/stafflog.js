document.addEventListener('DOMContentLoaded', function () {
    const loginForm = document.getElementById('login-form');
    const cancelButton = document.getElementById('cancel-btn');

    // Handle form submission
    loginForm.addEventListener('submit', function (event) {
        event.preventDefault(); // Prevent default form submission

        const role = document.getElementById('role').value;

        if (role === 'staff') {
            window.location.href = 'staffho.html'; // Redirect to staff home
        } else if (role === 'admin') {
            window.location.href = 'adminmanage.html'; // Redirect to admin home
        } else {
            alert('Please select a valid role.'); // Ensure a role is selected
        }
    });

    // Redirect to the home page when the cancel button is clicked
    cancelButton.addEventListener('click', function () {
        window.location.href = 'home.html'; // Redirects to home page
    });
});
