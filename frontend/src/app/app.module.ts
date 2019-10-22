import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes} from '@angular/router';
import { CommonModule} from '@angular/common';
import { AgmCoreModule } from '@agm/core';
import { AppComponent } from './app.component';

import { ManuService} from './service/manu.service';
import { HomestaffComponent } from './list-responsible/homestaff.component';
import { RegisterComponent } from './add-mold/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { PointComponent } from './add-location/point.component';
import { PointViewComponent } from './home-admin/point-view.component';
import { LayoutModule} from '@angular/cdk/layout';
import { CancelMemberComponent } from './list-mold/cancel-member.component';

import {
                MatAutocompleteModule,MatBadgeModule,
                MatBottomSheetModule,MatButtonModule,
                MatButtonToggleModule,MatCardModule,
                MatCheckboxModule,MatChipsModule,
                MatDatepickerModule, MatDialogModule,
                MatDividerModule,MatExpansionModule,
                MatGridListModule, MatIconModule,
                MatInputModule,MatListModule,
                MatMenuModule,MatNativeDateModule,
                MatPaginatorModule,MatProgressBarModule,
                MatProgressSpinnerModule,MatRadioModule,
                MatRippleModule,MatSelectModule,
                MatSidenavModule,MatSliderModule,
                MatSlideToggleModule, MatSnackBarModule,
                MatSortModule, MatStepperModule,
                MatTableModule,MatTabsModule,
                MatToolbarModule, MatTooltipModule,
                MatTreeModule,} from '@angular/material';
import { ShowTablesComponent } from './list-location/show-tables.component';
import { ResponsibleComponent } from './add-responsible/responsible.component';
import { LayoutComponent } from './layout/layout.component';
import {DragDropModule} from '@angular/cdk/drag-drop';

const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full' },
  {path: 'home', component: HomeComponent },
  {path: 'login', component: LoginComponent},
  {path: 'add-mold', component: RegisterComponent},
  {path: 'list-mold',component: CancelMemberComponent },  
  {path: 'add-responsible',component:ResponsibleComponent},
  {path: 'list-responsible', component: HomestaffComponent},
  {path: 'add-location',component:PointComponent},
  {path: 'show-location',component:ShowTablesComponent},
  {path: 'home/admin',component:PointViewComponent},
  {path: 'layout',component:LayoutComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    HomestaffComponent,
    RegisterComponent,
    LoginComponent, 
    HomeComponent,
    PointComponent,
    PointViewComponent,
    CancelMemberComponent,
    ShowTablesComponent,
    ResponsibleComponent,
    LayoutComponent],
  imports: [
    LayoutModule,
    DragDropModule,
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    CommonModule,
    MatAutocompleteModule,
    MatBadgeModule,
    MatBottomSheetModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatCardModule,
    MatCheckboxModule,
    MatChipsModule,
    MatDatepickerModule,
    MatDialogModule,
    MatDividerModule,
    MatExpansionModule,
    MatGridListModule,
    MatIconModule,
    MatInputModule,
    MatListModule,
    MatMenuModule,
    MatNativeDateModule,
    MatPaginatorModule,
    MatProgressBarModule,
    MatProgressSpinnerModule,
    MatRadioModule,
    MatRippleModule,
    MatSelectModule,
    MatSidenavModule,
    MatSliderModule,
    MatSlideToggleModule,
    MatSnackBarModule,
    MatSortModule,
    MatStepperModule,
    MatTableModule,
    MatTabsModule,
    MatToolbarModule,
    MatTooltipModule,
    MatTreeModule,
    RouterModule.forRoot(routes),
    AgmCoreModule.forRoot({apiKey: 'AIzaSyBS-fusP8ANNGCD1KGL7Bop1bqD1XcXTYk'}),
   

  ],
  entryComponents: [],
  providers: [ManuService],
  bootstrap: [AppComponent]
})
export class AppModule { }
