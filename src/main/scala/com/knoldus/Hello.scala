package com.knoldus

import components.{DependentComponent, ProjectComponent, EmployeeComponent}
import models.{DependentModel, ProjectModel, EmployeeModel}

import scala.concurrent.Await
import scala.concurrent.duration._

object Hello extends App{
  /**
    * Creation of schemas
    */
//  EmployeeComponent.createTable
//  Thread.sleep(5000)
//  ProjectComponent.createTable
//  Thread.sleep(5000)
//  DependentComponent.createTable
//  Thread.sleep(5000)
  /**
    * Manipulation of Employee
    */
//    EmployeeComponent.insert(EmployeeModel(2,"anmol"))
//    EmployeeComponent.insert(EmployeeModel(3,"anmol"))
//    EmployeeComponent.insert(EmployeeModel(4,"anmol"))
//    Thread.sleep(5000)

//    EmployeeComponent.delete(2)

//    EmployeeComponent.update(EmployeeModel(3,"Ammo"),true)
//    Thread.sleep(5000)

   EmployeeComponent.updateOrInsert(EmployeeModel(5,"Ammo"))
//    println(Await.result((EmployeeComponent.getAll()),10.seconds))
  /**
    * Manipulation of Project
    */
//    ProjectComponent.insert(ProjectModel(3,"RCL"))
//    ProjectComponent.insert(ProjectModel(6,"RCL"))
    Thread.sleep(10000)
  /**
    * Manipulation of Dependent
    */
//    DependentComponent.insert(DependentModel(4,"Anil","father",Some(5)))
//    DependentComponent.insert(DependentModel(4,"Anil","father",None))
//    DependentComponent.insert(DependentModel(2,"Anil","father",Some(5)))
//    Thread.sleep(5000)
}
