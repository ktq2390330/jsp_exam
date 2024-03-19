function toggleMenu() {
    var menu = document.getElementById('menu');
    var windowWidth = window.innerWidth;
    if (windowWidth < 769) {
        menu.style.transform = menu.style.transform === 'translateX(0%)' ? 'translateX(-100%)' : 'translateX(0%)';
    }
}
window.addEventListener('resize', function () {
    var menu = document.getElementById('menu');
    var windowWidth = window.innerWidth;
    if (windowWidth >= 769) {
        menu.style.transform = 'translateX(0%)';
    } else {
        menu.style.transform = 'translateX(-100%)';
    }
});