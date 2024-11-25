import express from 'express';
import tasks from '../controllers/tasksController.js';

const router = express.Router();

router.get('/', tasks.findAll);
router.get('/:id', tasks.findTarefa);
router.put('/:id', tasks.updateTarefa);
router.delete('/:id', tasks.deleteTarefa);
router.post('/', tasks.addTarefa);

export default router;
