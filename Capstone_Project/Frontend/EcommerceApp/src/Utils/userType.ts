// user-type.pipe.ts
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'userType'
})
export class UserTypePipe implements PipeTransform {
  transform(value: number): string {
    switch(value) {
      case 0: return 'Admin';
      case 1: return 'User';
      default: return 'Unknown';
    }
  }
}