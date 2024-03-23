import { ISong, NewSong } from './song.model';

export const sampleWithRequiredData: ISong = {
  id: 99772,
};

export const sampleWithPartialData: ISong = {
  id: 58501,
  genre: 'Djibouti Plastic Underpass',
  lyrics: 'Tasty Shoals',
  dating: 13356,
  worldLife: 38944,
  familyGospel: 70415,
  romantic: 7463,
  obscene: 63316,
  movementPlaces: 30380,
  feelings: 8805,
  acousticness: 66846,
  instrumentalness: 38416,
  topic: 'Total US SCSI',
};

export const sampleWithFullData: ISong = {
  id: 52493,
  artistName: 'panel',
  trackName: 'calculating',
  releaseDate: 53548,
  genre: 'state',
  lyrics: 'Checking',
  len: 34975,
  dating: 263,
  violence: 1675,
  worldLife: 71772,
  nightTime: 4803,
  shakeTheAudience: 15632,
  familyGospel: 49406,
  romantic: 52618,
  communication: 65493,
  obscene: 70693,
  music: 37320,
  movementPlaces: 50370,
  lightVisualPerceptions: 41492,
  familySpiritual: 45575,
  likeGirls: 69181,
  sadness: 34751,
  feelings: 3720,
  danceability: 11276,
  loudness: 99029,
  acousticness: 93631,
  instrumentalness: 46230,
  valence: 15135,
  energy: 55702,
  topic: 'Profound SAS synergize',
  age: 49635,
};

export const sampleWithNewData: NewSong = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
