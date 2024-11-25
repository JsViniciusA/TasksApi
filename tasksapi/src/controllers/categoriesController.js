import CategoryRepository from '../models/categoriesModel.js';

import { Category, User } from './models/index.js';


const router = express.Router();


router.post('/categories', async (req, res) => {
  try {
    const { name, userId } = req.body;
    const category = await Category.create({ name, userId });
    res.status(201).json(category);
  } catch (err) {
    res.status(400).json({ error: 'Erro ao criar categoria', details: err });
  }
});

router.get('/users/:userId/categories', async (req, res) => {
  try {
    const { userId } = req.params;
    const categories = await Category.findAll({ where: { userId } });
    res.json(categories);
  } catch (err) {
    res.status(400).json({ error: 'Erro ao buscar categorias', details: err });
  }
});


router.put('/categories/:id', async (req, res) => {
  try {
    const { id } = req.params;
    const { name } = req.body;
    const category = await Category.findByPk(id);
    if (!category) return res.status(404).json({ error: 'Categoria não encontrada' });
    category.name = name;
    await category.save();
    res.json(category);
  } catch (err) {
    res.status(400).json({ error: 'Erro ao atualizar categoria', details: err });
  }
});


router.delete('/categories/:id', async (req, res) => {
  try {
    const { id } = req.params;
    const category = await Category.findByPk(id);
    if (!category) return res.status(404).json({ error: 'Categoria não encontrada' });
    await category.destroy();
    res.status(204).send();
  } catch (err) {
    res.status(400).json({ error: 'Erro ao deletar uma categoria', details: err });
  }
});

module.exports = router;

export default { findAll, addCategory, findCategory, updateCategory, deleteCategory } 
