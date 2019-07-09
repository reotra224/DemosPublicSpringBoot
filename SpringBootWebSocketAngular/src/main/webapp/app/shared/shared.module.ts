import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { SpringBootWebScoketAngularSharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective } from './';

@NgModule({
  imports: [SpringBootWebScoketAngularSharedCommonModule],
  declarations: [JhiLoginModalComponent, HasAnyAuthorityDirective],
  entryComponents: [JhiLoginModalComponent],
  exports: [SpringBootWebScoketAngularSharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class SpringBootWebScoketAngularSharedModule {
  static forRoot() {
    return {
      ngModule: SpringBootWebScoketAngularSharedModule
    };
  }
}
