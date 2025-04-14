let subMenu = document.getElementById("subMenu");

function toggleMenu() {
    subMenu.classList.toggle("open-menu");
}

function displaySelectedImage(event, elementId) {
    const selectedImage = document.getElementById(elementId);
    const fileInput = event.target;

    if (fileInput.files && fileInput.files[0]) {
        const reader = new FileReader();

        reader.onload = function(e) {
            selectedImage.src = e.target.result;
        };

        reader.readAsDataURL(fileInput.files[0]);
    }
}

const sidebarIcon = document.querySelector(".aside_menu_button");
const sidebar = document.querySelector(".mobile-menu");

sidebarIcon.addEventListener('click', function() {
    if (sidebarIcon.classList.contains("toggled")) {
        sidebar.classList.remove("close");
        sidebarIcon.classList.remove("toggled");
        // TODO: fix animation
    } else {
        sidebar.classList.add("close");
        sidebarIcon.classList.add("toggled");
    }
});