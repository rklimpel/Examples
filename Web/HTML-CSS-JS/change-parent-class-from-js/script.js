function doStuff(){
    const element = document.getElementById("btnTest");
    let x = element.parentElement.classList.toggle("pink-background");
    console.log(x);
}