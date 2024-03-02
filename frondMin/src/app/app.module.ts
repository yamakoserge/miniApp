import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreatepostComponent } from './pages/createpost/createpost.component';
import { ViewallComponent } from './pages/viewall/viewall.component';
import { ViewuserComponent } from './pages/viewuser/viewuser.component';

@NgModule({
  declarations: [
    AppComponent,
    CreatepostComponent,
    ViewallComponent,
    ViewuserComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
