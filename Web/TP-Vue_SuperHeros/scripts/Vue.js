const { createApp } = Vue;

createApp({
    data() {
      return {
        superheros: [],    // <-- la liste qui sera remplie
      }
    },
    mounted() {
        axios.get('https://cdn.jsdelivr.net/gh/rtomczak/superhero-api@0.3.0/api/all.json')
        .then(response => {
        this.superheros = response.data; // Récupérer les données des superhéros
    })
        .catch(error => {
        console.log(error);
    });
    }

}).mount('#app');
