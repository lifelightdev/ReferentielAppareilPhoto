import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppareilListComponent  } from './appareil-list/appareil-list.component';
import { AppareilFormComponent } from './appareil-form/appareil-form.component';

const routes: Routes = [
  { path: 'appareils', component: AppareilListComponent},
  { path: 'addappareil', component: AppareilFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
