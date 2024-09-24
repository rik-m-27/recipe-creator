import React, { useState } from "react";

function RecipeGenerator() {
  const [ingredients, setIngredients] = useState("");
  const [cuisine, setCuisine] = useState("any");
  const [dietaryRestriction, setDietaryRestriction] = useState("");

  const [recipe, setRecipe] = useState("");

  const createRecipe = async () => {
    try {
      const response = await fetch(
        `http://localhost:8287/recipe-creator?ingredients=${ingredients}&cuisine=${cuisine}&dietaryRestriction=${dietaryRestriction}`
      );
      const data = await response.text();
      console.log(data);
      setRecipe(data);
    } catch (error) {
      console.error("Error generating chat : ", error);
    }
  };

  return (
    <div>
      <h2>Create a Recipe</h2>
      <input
        type="text"
        value={ingredients}
        onChange={(e) => setIngredients(e.target.value)}
        placeholder="Enter ingredients (comma seperated)"
      />
      <input
        type="text"
        value={cuisine}
        onChange={(e) => setCuisine(e.target.value)}
        placeholder="Enter cuisine (comma seperated)"
      />
      <input
        type="text"
        value={dietaryRestriction}
        onChange={(e) => setDietaryRestriction(e.target.value)}
        placeholder="Enter dietary restrictions (comma seperated)"
      />

      <button onClick={createRecipe}>Create Recipe</button>

      <div className="output">
        <pre className="recipe-text">{recipe}</pre>
      </div>
    </div>
  );
}

export default RecipeGenerator;
