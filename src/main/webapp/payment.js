document.addEventListener('DOMContentLoaded', function () {

    const confirmBtn = document.querySelector('.submit-btn');
    const cancelBtn = document.querySelector('.cancel-btn');

    confirmBtn.addEventListener('click', function () {
        const paymentId = document.getElementById('payment-id').value;
        const customerId = document.getElementById('customer-id').value;
        const amount = document.getElementById('amount').value;
        const paymentMethod = document.getElementById('payment-method').value;
        const paymentDate = new Date().toISOString().split('T')[0]; 
        const status = 'Completed'; 

        sendPaymentRequest(paymentId, customerId, amount, paymentMethod, paymentDate, status);

        alert('Payment Successful... Thank you.');
    });

    cancelBtn.addEventListener('click', function () {
        const userConfirmed = confirm('Do you really want to cancel your payment?');
        if (userConfirmed) {
            cancelPayment(); 
        }
    });
});

function sendPaymentRequest(paymentId, customerId, amount, paymentMethod, paymentDate, status) {
    const url = '/abcresturant/payment'; 

    const formData = new URLSearchParams();
    formData.append('paymentId', paymentId);
    formData.append('customerId', customerId);
    formData.append('amount', amount);
    formData.append('paymentMethod', paymentMethod);
    formData.append('paymentDate', paymentDate);
    formData.append('status', status);

    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded', 
        },
        body: formData.toString(), 
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json(); 
    })
    .then(result => {
        console.log('Success:', result);
    })
    .catch(error => {
        console.error('Error:', error);
    });
}
