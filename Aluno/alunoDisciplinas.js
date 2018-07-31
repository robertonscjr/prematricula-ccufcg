const listagem_view = document.getElementById('listagem');

const disciplinas = [];

function update_view() {
    disciplinas.sort((a, b) => a.created_at > b.created_at ? -1 : 1);
    const items = disciplinas.map(e => `<div class="table-responsive">
 	<table class="table table-striped table-hover table-condensed" id="tabOferta">
                <thead>
                    <tr>
                        <th class="text-center">Período</th>
                        <th>Disciplina</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td class="text-center">
                            1</td>
                        <td>
                            FUND DE MATEMATICA P/ C.DA COMPUTACAO I</td>
                    </tr>
                </tbody>
            </table>`).join(" ");;
    disciplinas_view.innerHTML = '<ul>' + items + '</ul>';
}

fetch('/disciplinas', {

    method: "GET",
    body: form
});