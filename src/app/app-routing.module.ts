import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddComponent } from './Persona/add/add.component';
import { ListarComponent } from './Persona/listar/listar.component';

const routes: Routes = [
  {path: 'add', component:AddComponent},
  {path: 'listar', component:ListarComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
