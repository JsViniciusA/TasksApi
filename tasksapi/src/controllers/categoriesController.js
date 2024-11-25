import express from 'express';
import Categories from '../models/categoriesModel.js';
export { Categories };



function findAll(req, res) {
  TaskRepository.findAll().then((result) => res.json(result));
}

function findCategoria(req, res) {
  TaskRepository.findByPk(req.params.id)
      .then((result) => res.json(result))
}

async function addCategoria(req, res) {
  const categoria= req.body;
  const categoriaCriada = await this.categoriaUseCase.cadastrar(categoria);
  return res.status(201).json(categoriaCriada);
};


async function updateCategoria(req,res){
  await TaskRepository.update({
      nome: req.body.nome
  },
  {
      where: {
        id: req.params.id
  }
  })};

  async function deleteCategoria(req,res){
      await TasksRepository.destroy({
          where: {
            id: req.params.id
          }
        });
  
      UserRepository.findAll().then((result) => res.json(result));
  };

export default { findAll, addCategoria, findCategoria, updateCategoria, deleteCategoria } 
