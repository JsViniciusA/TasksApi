import express from 'express';
import categories from '../controllers/categoriesController.js';



const router = express.Router();

router.get('/', categories.findAll);
router.get('/:id', categories.findCategory);
router.put('/:id', categories.updateCategory);
router.delete('/:id', categories.deleteCategory);
router.post('/', categories.addCategory);

export default router;
