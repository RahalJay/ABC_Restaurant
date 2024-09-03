// staffreg.js

document.getElementById('registration-form').addEventListener('submit', function(event) {
    event.preventDefault();

    // Display popup message
    const popup = document.getElementById('popup');
    popup.style.display = 'block';

    // Hide the popup after 3 seconds
    setTimeout(function() {
        popup.style.display = 'none';
    }, 3000);

    // Mock implementation of sending registration data (can be integrated with a backend)
    const email = document.getElementById('email').value;
    sendRegistrationEmail(email);
});

function sendRegistrationEmail(email) {
    // Mock implementation of sending an email
    console.log(`Registration email sent to ${email}`);
    alert(`A confirmation email has been sent to ${email}`);
}

// Cancel button redirects to home page
document.getElementById('cancel').addEventListener('click', function() {
    window.location.href = 'adminmanage.html';
});
