import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { OemsAdminSharedModule } from 'app/shared/shared.module';
import { HOME_ROUTE } from './home.route';
import { HomeComponent } from './home.component';

@NgModule({
  imports: [OemsAdminSharedModule, RouterModule.forChild([HOME_ROUTE])],
  declarations: [HomeComponent],
})
export class OemsAdminHomeModule {}
