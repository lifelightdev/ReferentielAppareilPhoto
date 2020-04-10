import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppareilListComponent  } from './appareil-list/appareil-list.component';

const routes: Routes = [
  { path: 'appareils', component: AppareilListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
