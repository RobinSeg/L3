const tauxUSD = 1.08;  // 1 € = 1.08 $
const tauxAUD = 1.65;  // 1 € = 1.65 AU$

const euro = document.getElementById("euro");
const usd = document.getElementById("usd");
const aud = document.getElementById("aud");
const btn = document.getElementById("convertir");

function majDepuisEuro() {
  let val = parseFloat(euro.value) || 0;
  usd.value = (val * tauxUSD).toFixed(2);
  aud.value = (val * tauxAUD).toFixed(2);
}
    
function majDepuisUSD() {
  let val = parseFloat(usd.value) || 0;
  euro.value = (val / tauxUSD).toFixed(2);
  aud.value = (val /tauxUSD * tauxAUD).toFixed(2);
}

function majDepuisAUD() {
  let val = parseFloat(aud.value) || 0;
  euro.value = (val / tauxAUD).toFixed(2);
  usd.value = (val / tauxAUD * tauxUSD).toFixed(2);
}

euro.addEventListener("input", majDepuisEuro);
usd.addEventListener("input", majDepuisUSD);
aud.addEventListener("input", majDepuisAUD);

// --- Initialisation
majDepuisEuro();
majDepuisUSD();
majDepuisAUD();
