document.addEventListener('DOMContentLoaded', function () {
    const galleryContainer = document.getElementById('gallery-container');

    // Add Image
    window.addImage = function () {
        const imageId = document.getElementById('image-id').value;
        const imageTitle = document.getElementById('image-title').value;
        const imageDescription = document.getElementById('image-description').value;
        const imageFile = document.getElementById('image-file').files[0];

        if (!imageFile) {
            alert('Please select an image file to upload.');
            return;
        }

        const reader = new FileReader();
        reader.onload = function (e) {
            const imgElement = document.createElement('div');
            imgElement.classList.add('gallery-item');
            imgElement.innerHTML = `
                <img src="${e.target.result}" alt="${imageTitle}" style="width: 100px; height: 100px;">
                <h3>${imageTitle}</h3>
                <p>${imageDescription}</p>
                <button onclick="deleteImage('${imageId}')">Delete</button>
            `;
            galleryContainer.appendChild(imgElement);
        };
        reader.readAsDataURL(imageFile);
    };

    // Update Image
    window.updateImage = function () {
        const imageId = document.getElementById('image-id').value;
        const imageTitle = document.getElementById('image-title').value;
        const imageDescription = document.getElementById('image-description').value;
        const imageFile = document.getElementById('image-file').files[0];

        if (!imageId) {
            alert('Please enter the image ID to update.');
            return;
        }

        const galleryItems = document.querySelectorAll('.gallery-item');
        galleryItems.forEach(item => {
            const itemTitle = item.querySelector('h3').innerText;
            if (itemTitle === imageTitle) {
                if (imageFile) {
                    const reader = new FileReader();
                    reader.onload = function (e) {
                        item.querySelector('img').src = e.target.result;
                    };
                    reader.readAsDataURL(imageFile);
                }
                item.querySelector('p').innerText = imageDescription;
            }
        });
    };

    // Delete Image
    window.deleteImage = function (imageId) {
        const galleryItems = document.querySelectorAll('.gallery-item');
        galleryItems.forEach(item => {
            const deleteButton = item.querySelector('button');
            if (deleteButton && deleteButton.innerText === 'Delete') {
                deleteButton.addEventListener('click', function () {
                    item.remove();
                });
            }
        });
    };
});
