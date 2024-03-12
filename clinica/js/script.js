// script.js
document.addEventListener('DOMContentLoaded', (event) => {
    // O código JavaScript para interatividade poderia ir aqui.
    // Por exemplo, para um efeito de smooth scroll:

    document.querySelectorAll('a[href^="#"]').forEach(anchor => {
        anchor.addEventListener('click', function (e) {
            e.preventDefault();
            document.querySelector(this.getAttribute('href')).scrollIntoView({
                behavior: 'smooth'
            });
        });
    });

    // Qualquer outra interatividade que sua landing page possa precisar.
});
