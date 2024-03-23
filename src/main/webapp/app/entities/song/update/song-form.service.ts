import { Injectable } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

import { ISong, NewSong } from '../song.model';

/**
 * A partial Type with required key is used as form input.
 */
type PartialWithRequiredKeyOf<T extends { id: unknown }> = Partial<Omit<T, 'id'>> & { id: T['id'] };

/**
 * Type for createFormGroup and resetForm argument.
 * It accepts ISong for edit and NewSongFormGroupInput for create.
 */
type SongFormGroupInput = ISong | PartialWithRequiredKeyOf<NewSong>;

type SongFormDefaults = Pick<NewSong, 'id'>;

type SongFormGroupContent = {
  id: FormControl<ISong['id'] | NewSong['id']>;
  artistName: FormControl<ISong['artistName']>;
  trackName: FormControl<ISong['trackName']>;
  releaseDate: FormControl<ISong['releaseDate']>;
  genre: FormControl<ISong['genre']>;
  lyrics: FormControl<ISong['lyrics']>;
  len: FormControl<ISong['len']>;
  dating: FormControl<ISong['dating']>;
  violence: FormControl<ISong['violence']>;
  worldLife: FormControl<ISong['worldLife']>;
  nightTime: FormControl<ISong['nightTime']>;
  shakeTheAudience: FormControl<ISong['shakeTheAudience']>;
  familyGospel: FormControl<ISong['familyGospel']>;
  romantic: FormControl<ISong['romantic']>;
  communication: FormControl<ISong['communication']>;
  obscene: FormControl<ISong['obscene']>;
  music: FormControl<ISong['music']>;
  movementPlaces: FormControl<ISong['movementPlaces']>;
  lightVisualPerceptions: FormControl<ISong['lightVisualPerceptions']>;
  familySpiritual: FormControl<ISong['familySpiritual']>;
  likeGirls: FormControl<ISong['likeGirls']>;
  sadness: FormControl<ISong['sadness']>;
  feelings: FormControl<ISong['feelings']>;
  danceability: FormControl<ISong['danceability']>;
  loudness: FormControl<ISong['loudness']>;
  acousticness: FormControl<ISong['acousticness']>;
  instrumentalness: FormControl<ISong['instrumentalness']>;
  valence: FormControl<ISong['valence']>;
  energy: FormControl<ISong['energy']>;
  topic: FormControl<ISong['topic']>;
  age: FormControl<ISong['age']>;
};

export type SongFormGroup = FormGroup<SongFormGroupContent>;

@Injectable({ providedIn: 'root' })
export class SongFormService {
  createSongFormGroup(song: SongFormGroupInput = { id: null }): SongFormGroup {
    const songRawValue = {
      ...this.getFormDefaults(),
      ...song,
    };
    return new FormGroup<SongFormGroupContent>({
      id: new FormControl(
        { value: songRawValue.id, disabled: true },
        {
          nonNullable: true,
          validators: [Validators.required],
        }
      ),
      artistName: new FormControl(songRawValue.artistName),
      trackName: new FormControl(songRawValue.trackName),
      releaseDate: new FormControl(songRawValue.releaseDate),
      genre: new FormControl(songRawValue.genre),
      lyrics: new FormControl(songRawValue.lyrics),
      len: new FormControl(songRawValue.len),
      dating: new FormControl(songRawValue.dating),
      violence: new FormControl(songRawValue.violence),
      worldLife: new FormControl(songRawValue.worldLife),
      nightTime: new FormControl(songRawValue.nightTime),
      shakeTheAudience: new FormControl(songRawValue.shakeTheAudience),
      familyGospel: new FormControl(songRawValue.familyGospel),
      romantic: new FormControl(songRawValue.romantic),
      communication: new FormControl(songRawValue.communication),
      obscene: new FormControl(songRawValue.obscene),
      music: new FormControl(songRawValue.music),
      movementPlaces: new FormControl(songRawValue.movementPlaces),
      lightVisualPerceptions: new FormControl(songRawValue.lightVisualPerceptions),
      familySpiritual: new FormControl(songRawValue.familySpiritual),
      likeGirls: new FormControl(songRawValue.likeGirls),
      sadness: new FormControl(songRawValue.sadness),
      feelings: new FormControl(songRawValue.feelings),
      danceability: new FormControl(songRawValue.danceability),
      loudness: new FormControl(songRawValue.loudness),
      acousticness: new FormControl(songRawValue.acousticness),
      instrumentalness: new FormControl(songRawValue.instrumentalness),
      valence: new FormControl(songRawValue.valence),
      energy: new FormControl(songRawValue.energy),
      topic: new FormControl(songRawValue.topic),
      age: new FormControl(songRawValue.age),
    });
  }

  getSong(form: SongFormGroup): ISong | NewSong {
    return form.getRawValue() as ISong | NewSong;
  }

  resetForm(form: SongFormGroup, song: SongFormGroupInput): void {
    const songRawValue = { ...this.getFormDefaults(), ...song };
    form.reset(
      {
        ...songRawValue,
        id: { value: songRawValue.id, disabled: true },
      } as any /* cast to workaround https://github.com/angular/angular/issues/46458 */
    );
  }

  private getFormDefaults(): SongFormDefaults {
    return {
      id: null,
    };
  }
}
