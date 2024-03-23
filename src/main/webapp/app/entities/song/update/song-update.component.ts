import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { finalize } from 'rxjs/operators';

import { SongFormService, SongFormGroup } from './song-form.service';
import { ISong } from '../song.model';
import { SongService } from '../service/song.service';

@Component({
  selector: 'jhi-song-update',
  templateUrl: './song-update.component.html',
})
export class SongUpdateComponent implements OnInit {
  isSaving = false;
  song: ISong | null = null;

  editForm: SongFormGroup = this.songFormService.createSongFormGroup();

  constructor(protected songService: SongService, protected songFormService: SongFormService, protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ song }) => {
      this.song = song;
      if (song) {
        this.updateForm(song);
      }
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const song = this.songFormService.getSong(this.editForm);
    if (song.id !== null) {
      this.subscribeToSaveResponse(this.songService.update(song));
    } else {
      this.subscribeToSaveResponse(this.songService.create(song));
    }
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<ISong>>): void {
    result.pipe(finalize(() => this.onSaveFinalize())).subscribe({
      next: () => this.onSaveSuccess(),
      error: () => this.onSaveError(),
    });
  }

  protected onSaveSuccess(): void {
    this.previousState();
  }

  protected onSaveError(): void {
    // Api for inheritance.
  }

  protected onSaveFinalize(): void {
    this.isSaving = false;
  }

  protected updateForm(song: ISong): void {
    this.song = song;
    this.songFormService.resetForm(this.editForm, song);
  }
}
