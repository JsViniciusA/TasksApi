import express from "express";
import routes from "./tasksapi/src/routers/routes.js";



/* GET home page. */
routes.get("/", function (req, res, next) {
    res.status(200).send("Ok").end();
});

export { routes as default };