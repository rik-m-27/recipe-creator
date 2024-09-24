import React, { useState } from "react";
import "./App.css";
import ChatWithAI from "./components/ChatWithAI";
import RecipeGenerator from "./components/RecipeGenerator";

function App() {
  // making a constant called activeTab
  const [activeTab, setActiveTab] = useState("recipe-generator");

  // passing tab name as parameter

  const handleTabChange = (tab) => {
    // alert(tab);
    setActiveTab(tab);
  };

  return (
    <div className="App">
      <button
        className={activeTab === "recipe-generator" ? "active" : ""}
        onClick={() => handleTabChange("recipe-generator")}
      >
        Recipe Generator
      </button>

      <button
        className={activeTab === "chat" ? "active" : ""}
        onClick={() => handleTabChange("chat")}
      >
        Ask AI
      </button>

      {/* trying to conditionally rendering */}
      <div>
        {activeTab === "recipe-generator" && <RecipeGenerator />}
        {activeTab === "chat" && <ChatWithAI />}
      </div>
    </div>
  );
}

export default App;
