// facilities.js

document.addEventListener('DOMContentLoaded', function () {
    const facilityItems = document.querySelectorAll('.facility-item');

    facilityItems.forEach(item => {
        item.addEventListener('click', function () {
            const facilityName = this.querySelector('h3').innerText;
            const facilityDescription = this.querySelector('p').innerText;
            showFacilityModal(facilityName, facilityDescription);
        });
    });

    function showFacilityModal(name, description) {
        const modalHTML = `
            <div class="modal">
                <div class="modal-content">
                    <span class="close-button">&times;</span>
                    <h2>${name}</h2>
                    <p>${description}</p>
                </div>
            </div>
        `;
        document.body.insertAdjacentHTML('beforeend', modalHTML);

        const modal = document.querySelector('.modal');
        const closeButton = modal.querySelector('.close-button');

        closeButton.addEventListener('click', () => {
            modal.remove();
        });

        modal.addEventListener('click', (e) => {
            if (e.target === modal) {
                modal.remove();
            }
        });
    }
});
