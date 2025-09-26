document.querySelector("#wiki").href = "https://fr.wikipedia.org";



const labels = document.getElementsByName("choix");
labels[0].nextSibling.textContent = "HP";
labels[1].nextSibling.textContent = "Casque";
labels[2].nextSibling.textContent = "Bluetooth";


document.querySelectorAll("input[name='choix']").forEach(r => {
r.onchange = function() {
let txt = this.nextSibling.textContent.trim();
document.getElementById("volumeLabel").textContent = "Volume " + txt;
};
});


let vol = document.getElementById("volume");
vol.max = 100;
console.log("Max volume :", vol.max);


vol.oninput = function() {
document.getElementById("valeur").textContent = this.value;
};


let img = document.createElement("img");
img.src = "https://upload.wikimedia.org/wikipedia/commons/b/bd/UPHF_logo.svg";
img.width = 200;
document.getElementById("lien").appendChild(img);
