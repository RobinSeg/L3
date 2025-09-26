const app = document.getElementById("app");

const titre = document.createElement("h2");
titre.textContent = "Titre h2 !";
app.appendChild(titre);

const div2 = document.createElement("div");
div2.setAttribute("class","gallery");
div2.className  = "gallery";
app.appendChild(div2);

//V1
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

//V2 , boucle par chatGPT
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

