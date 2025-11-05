import React, { useState, useEffect } from 'react';
import heros from './SuperHeros.json';
import './index.css';

function App() {
  const nom = "Toto";
  const [compteur, setCompteur] = useState(0);
  const [search, setSearch] = useState("");

  useEffect(() => {
    document.title = `Compteur : ${compteur}`;
  }, [compteur]);

  const filteredHeros = heros.filter(hero =>
    hero.name.toLowerCase().includes(search.toLowerCase())
  );

  return (
    <div className="app-container">
      <h1>Bonjour {nom}, je découvre React !</h1>
      <h2>Compteur : {compteur}</h2>
      <button onClick={() => setCompteur(compteur + 1)}>+</button>
      <button onClick={() => setCompteur(0)}>Réinitialiser</button>

      <p>Il y a {heros.length} super-héros dans la base.</p>

      <input
        type="text"
        placeholder="Rechercher un héros..."
        value={search}
        onChange={(e) => setSearch(e.target.value)}
      />

      <ul>
        {filteredHeros.map(hero => (
          <li key={hero.id}>{hero.name}</li>
        ))}
      </ul>
    </div>
  );
}

export default App;
