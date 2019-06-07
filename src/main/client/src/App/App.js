import React from "react";
import "./App.css";

import { TextComponent } from "./Components/TextComponent/TextComponent";

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
        <TextComponent />
      </header>
    </div>
  );
}

export default App;
