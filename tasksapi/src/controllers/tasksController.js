import TaskRepository from '../models/tasksModel.js';

function findAll(req, res) {
    TaskRepository.findAll().then((result) => res.json(result));
}

function findTarefa(req, res) {
    TaskRepository.findByPk(req.params.id)
        .then((result) => res.json(result))
}

async function addTarefa(req, res) {
    const tarefa = req.body;
    const tarefaCriada = await this.tarefaUseCase.cadastrar(tarefa);
    return res.status(201).json(tarefaCriada);
};


async function updateTarefa(req,res){
    await TaskRepository.update({
        nome: req.body.nome
    },
    {
        where: {
          id: req.params.id
    }
    })};

    async function deleteTarefa(req,res){
        await TasksRepository.destroy({
            where: {
              id: req.params.id
            }
          });
    
        UserRepository.findAll().then((result) => res.json(result));
    };
    

export default { findAll, addTarefa, findTarefa, updateTarefa, deleteTarefa }

