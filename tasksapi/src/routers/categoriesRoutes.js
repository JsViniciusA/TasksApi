import express from 'express';
import categories from '../controllers/categoriesController.js';



const router = express.Router();

router.get('/', categories.findAll);
router.get('/:id', categories.findCategoria);
router.put('/:id', categories.updateCategoria);
router.delete('/:id', categories.deleteCategoria);
router.post('/', categories.addCategoria);

export default router;
