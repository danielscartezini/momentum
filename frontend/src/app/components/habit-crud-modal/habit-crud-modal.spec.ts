import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HabitCrudModal } from './habit-crud-modal';

describe('HabitCrudModal', () => {
  let component: HabitCrudModal;
  let fixture: ComponentFixture<HabitCrudModal>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HabitCrudModal],
    }).compileComponents();

    fixture = TestBed.createComponent(HabitCrudModal);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
