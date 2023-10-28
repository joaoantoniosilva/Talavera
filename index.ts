import Fullstory from './fullstory';

declare global {
  interface Window {
    __wr_on_ready: () => void;
    _fs_ready: any;
  }
}

export interface WixRecorderOptions {
  sample?: number;
  smallApp?: boolean;
}

export interface WixRecorder {
  addLabel(label: string): Promise<void>;
  withExperiments(specs: { [specKey: string]: string }): Promise<void>;
  recordUrl(): Promise<string>;
  addCustomAttribute(key: string, value: string | string[]): Promise<void>;
  __forceRecording(): Promise<void>;
}

const options = getRecorderOptions();

const GENERIC_EVENT_NAME = 'wix recorder custom attribute';

const fullstory = new Fullstory({
  onReady: window.__wr_on_ready,
  sample: options.sample,
  smallApp: options.smallApp,
});

fullstory.setup();

export async function addLabel(label: string) {
  return fullstory.event(GENERIC_EVENT_NAME, { label });
}

export async function withExperiments(specs: {
  [specKey: string]: string;
}): Promise<void> {
  fullstory.event('Experiment', specs);
}

export async function addCustomAttribute(
  key: string,
  value: string | string[],
): Promise<void> {
  fullstory.event(GENERIC_EVENT_NAME, { [key]: value });
}

export async function recordUrl(): Promise<string> {
  return fullstory.getCurrentSessionUrl();
}

export async function __forceRecording(): Promise<void> {
  return fullstory.forceLoadFullstory();
}

function getRecorderOptions(): WixRecorderOptions {
  const opts = {} as WixRecorderOptions;

  try {
    const data = document?.currentScript?.dataset;

    if (data) {
      opts.sample =
        typeof data.sample === 'string' ? parseFloat(data.sample) : undefined;
      opts.smallApp = data.smallApp === 'true';
    }
  } catch {}

  return opts;
}
