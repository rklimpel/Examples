function toggleActive(el) {
    let x = el.parentElement.classList.toggle("pink-background");
    let otherElements = document.querySelectorAll('.btnBlubb');
    otherElements.forEach(element => {
        if (element !== el) {
            element.parentElement.classList.remove("pink-background");
        }
    });
}