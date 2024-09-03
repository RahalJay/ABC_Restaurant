document.addEventListener('DOMContentLoaded', function () {
    // Get the confirm and cancel buttons
    const confirmBtn = document.querySelector('.submit-btn');
    const cancelBtn = document.querySelector('.cancel-btn');

    // Confirm payment button event
    confirmBtn.addEventListener('click', function () {
        alert('Payment Successful... Thank you.');
    });

    // Cancel payment button event
    cancelBtn.addEventListener('click', function () {
        const userConfirmed = confirm('Do you really want to cancel your payment?');
        if (userConfirmed) {
            cancelPayment();  // Call the existing cancelPayment function to reset the form
        }
    });
});
