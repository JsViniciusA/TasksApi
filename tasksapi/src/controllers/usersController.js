import UserRepository  from '../models/usersModel.js';

function findAll(req,res){
    UserRepository.findAll().then( (result) => res.json(result));
}

function findUser(req,res){
    UserRepository.findByPk(req.params.id)
    .then( (result) => res.json(result))
}

function addUser(req,res){
    UserRepository.create({
        nome: req.body.nome,
        email: req.body.email
    }).then( (result) => res.json(result))
};

async function updateUser(req,res){
    await UserRepository.update({
        nome: req.body.nome,
        email: req.body.email
    },
    {
        where: {
          id: req.params.id
    }
    });

    UserRepository.findByPk(req.params.id)
    .then( (result) => res.json(result))
};

async function deleteUser(req,res){
    await UserRepository.destroy({
        where: {
          id: req.params.id
        }
      });

    UserRepository.findAll().then((result) => res.json(result));
};

export default { findAll, addUser, findUser, updateUser, deleteUser } 

