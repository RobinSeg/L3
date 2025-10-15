const app = Vue.createApp({
    data() {
      return { 
        compteur: 0,
        texteSaisi: '',
        texteBase : 'Texte2 : '       
       }
    },
    methods: {
      incrementer() {
        this.compteur++
      }
    }
  })
  app.mount('#app');

/**/
let textarea = document.getElementById("app2");
let p = document.getElementById("prg1");

let textdebase = p.textContent;

textarea.addEventListener("input", (event) =>
{
  let text = event.target.value;
  p.textContent = textdebase + text;
}
);