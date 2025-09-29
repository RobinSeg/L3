const app = document.getElementById("app");

const titre = document.createElement("h2");
titre.textContent = "Galerie";
app.appendChild(titre);

const div2 = document.createElement("div");
div2.setAttribute("class","gallery");
div2.className  = "gallery";
app.appendChild(div2);

//V1 , approche basique
/*
    const img1 = document.createElement("img");
    img1.setAttribute("src","https://upload.wikimedia.org/wikipedia/commons/thumb/b/bd/UPHF_logo.svg/1200px-UPHF_logo.svg.png");
    img1.setAttribute("width","300");
    div2.appendChild(img1);

    const img2 = document.createElement("img");
    img2.setAttribute("src","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfnf7XDjX4LeaxgCEmLpNkmNOzMf4tJrUCP4gxqiWHFg&s&ec=73068123");
    img2.setAttribute("width","300");
    div2.appendChild(img2);

    const img3 = document.createElement("img");
    img3.setAttribute("src","https://www.johnnybekaert.be/img/portfolio/LOGO-UPHF-RECHTS-1.png");
    img3.setAttribute("width","300");
    div2.appendChild(img3);
*/
//

//V2 , tout les urls dans une liste + boucle par chatGPT
const urls = [
  "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bd/UPHF_logo.svg/1200px-UPHF_logo.svg.png",
  "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfnf7XDjX4LeaxgCEmLpNkmNOzMf4tJrUCP4gxqiWHFg&s&ec=73068123",
  "https://www.johnnybekaert.be/img/portfolio/LOGO-UPHF-RECHTS-1.png"
];

urls.forEach( url => 
    {
        const img = document.createElement("img");
        img.setAttribute("src",url);
        img.setAttribute("width","300");
        div2.appendChild(img);
    }
)
//



// création d'un style pour pouvoir l'appliquer aux images quand je leur clique dessus
const style = document.createElement("style");
style.textContent = `
  .highlight {
    border: 3px solid red;
  }
`;
document.head.appendChild(style);


const images = div2.querySelectorAll("img");

images.forEach( img => {

    img.addEventListener("click", function() {

        console.log("URL =", img.getAttribute("src"));
        img.classList.toggle("highlight");

    });
});



// Diaporama
const btnStart = document.createElement("button");
btnStart.textContent = "Lancer le diaporama";
app.appendChild(btnStart);



const firstImage = div2.querySelector("img"); // sélectionne la première image
firstImage.style.background = "white";

let index = 0;
let timer = null;



btnStart.addEventListener("click", function() {
  if (timer) return; // pour ne pas lancer plusieurs diapo en même temps

  timer = setInterval(() => {
    const images = div2.querySelectorAll("img");

    images.forEach(img => img.classList.remove("diapo"));
    images[index].classList.add("diapo");

    // changer le titre qui indique l'image
    titre.innerHTML = "Image actuelle : " + (index + 1);

    // on passe à l'image suivante
    index = (index + 1) % images.length;
  }, 2000);
});



// bouton Pause du diapo
const btnPause = document.createElement("button");
btnPause.textContent = "Pause";
app.appendChild(btnPause);

btnPause.addEventListener("click", function() {
    const images = div2.querySelectorAll("img");
    const currentIndex = (index - 1 + images.length) % images.length;
    titre.innerHTML = "Pause sur Image : " + (currentIndex + 1);
    clearInterval(timer);
    timer = null;
});



const champtext = document.createElement("input");
champtext.setAttribute("type","text");
champtext.placeholder = "Entre une URL d'image";
app.appendChild(champtext);

const ajtImg = document.createElement("button");
ajtImg.textContent = "Ajouter une image";
app.appendChild(ajtImg);

ajtImg.addEventListener("click", function() {

    const url = champtext.value.trim();
    if (!url) return;

    const img = document.createElement("img");
    img.src = url;
    img.width = 300;

    img.addEventListener("click", function() {
    console.log("URL =", img.getAttribute("src"));
    img.classList.toggle("highlight");

    });

    div2.appendChild(img);
    champtext.value = "";
});

// je me suis rendu compte qu'après avoir ajouter une image avec l'etape 6,
// si elle est trop grande, mon code fait déborder au dessus des boutons.
style.textContent += `
  /* Styles globaux pour la galerie */
  .gallery img {
    max-width: 300px;
    max-height: 200px;
    object-fit: contain;
  }

  /* Diaporama */
  .diapo {
    border: 1px solid black;
    position: fixed;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%) scale(1.5);
    transition: transform 0.3s ease;
    z-index: 1;  /* image en dessous des boutons */
    max-width: 80vw;
    max-height: 80vh;
  }

  /* Boutons et champ texte fixés */
  .controls {
    position: fixed;
    bottom: 20px;       /* distance depuis le bas */
    left: 50%;          /* centrer horizontalement */
    transform: translateX(-50%);
    z-index: 10;        /* au-dessus des images */
    display: flex;
    gap: 10px;          /* espace entre les éléments */
  }

  .controls input {
    width: 300px;
    padding: 5px;
  }
`;

console.log("Premier enfant de #app :", app.firstChild);
console.log("Dernier enfant de #app :", app.lastChild);
console.log("Nombre de boutons :", document.getElementsByTagName("button").length);