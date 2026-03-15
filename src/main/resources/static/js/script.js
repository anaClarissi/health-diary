function openForm(formId) {

    document.getElementById(formId).style.display = "block";

}

function closeForm(formId) {

    document.getElementById(formId).style.display = "none";

}

function updateExercise(element) {

    console.log("Botão clicado!"); // Verifica se a função é disparada
    
    const form = document.getElementById('update-exercise-form');
    if (!form) {
        alert("Erro: Formulário 'update-exercise-form' não encontrado no HTML!");
        return;
    }

    openForm('update-exercise-form')

    document.getElementById('id').value = element.getAttribute("data-id");

    document.getElementById('updateExerciseDate').value = element.getAttribute("data-date");

    document.getElementById('updateExerciseName').value = element.getAttribute("data-name");

    document.getElementById('updateExerciseSeries').value = element.getAttribute("data-series");

    document.getElementById('updateExerciseRepetitions').value = element.getAttribute("data-repetitions");

    document.getElementById('updateExerciseLoad').value = element.getAttribute("data-load");

    document.getElementById('updateExerciseTime').value = element.getAttribute("data-time");

    const id = element.getAttribute("data-id");
   
    document.querySelector("#update-exercise-form form").setAttribute("action", `/exercise/edit/${id}`);

}