import express from 'express';
import users from '../controllers/usersController.js';

const router = express.Router();

router.get('/', users.findAll);
router.get('/:id', users.findUser);
router.put('/:id', users.updateUser);
router.delete('/:id', users.deleteUser);
router.post('/', users.addUser);

export default router;
