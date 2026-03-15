function openForm(formId) {

    document.getElementById(formId).style.display = "block";

}

function closeForm(formId) {

    document.getElementById(formId).style.display = "none";

}

function updateExercise(element) {

    openForm('update-exercise-form')

    document.getElementById('idExercise').value = element.getAttribute("data-id");

    document.getElementById('updateExerciseDate').value = element.getAttribute("data-date");

    document.getElementById('updateExerciseName').value = element.getAttribute("data-name");

    document.getElementById('updateExerciseSeries').value = element.getAttribute("data-series");

    document.getElementById('updateExerciseRepetitions').value = element.getAttribute("data-repetitions");

    document.getElementById('updateExerciseLoad').value = element.getAttribute("data-load");

    document.getElementById('updateExerciseTime').value = element.getAttribute("data-time");

    const id = element.getAttribute("data-id");
   
    document.querySelector("#update-exercise-form form").setAttribute("action", `/exercise/edit/${id}`);

}

function updateMeal(element) {

    openForm('update-meal-form');

    document.getElementById('idMeal').value = element.getAttribute("data-id");

    document.getElementById('updateMealType').value = element.getAttribute("data-type");

    document.getElementById('updateMealDescription').value = element.getAttribute("data-description");

    document.getElementById('updateMealQuantity').value = element.getAttribute("data-quantity");

    document.getElementById('updateMealRegisterDate').value = element.getAttribute("data-registerDate");

    const id = element.getAttribute("data-id");

    document.querySelector("#update-meal-form form").setAttribute("action", `/meal/edit/${id}`);

}