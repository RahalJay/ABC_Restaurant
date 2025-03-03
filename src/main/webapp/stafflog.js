document.addEventListener('DOMContentLoaded', function () {
    const loginForm = document.getElementById('login-form');
    const cancelButton = document.getElementById('cancel-btn');

    loginForm.addEventListener('submit', function (event) {
        event.preventDefault(); 

        const role = document.getElementById('role').value;

        if (role === 'staff') {
            window.location.href = 'staffho.html'; 
        } else if (role === 'admin') {
            window.location.href = 'adminmanage.html'; 
        } else {
            alert('Please select a valid role.'); 
        }
    });

    cancelButton.addEventListener('click', function () {
        window.location.href = 'home.html'; 
    });
});
