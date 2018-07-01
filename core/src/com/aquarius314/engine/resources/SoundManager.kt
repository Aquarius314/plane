package com.aquarius314.engine.resources

import com.aquarius314.plane.main.Settings
import com.badlogic.gdx.audio.Sound
import com.badlogic.gdx.Gdx



class SoundManager(files: List<String>) : ResourceManager<Sound>(files) {

    override fun loadAssets() {
        for(soundFileName in files) {
            loadSound(soundFileName)
        }
    }

    private fun loadSound(fileName: String) {
        try {
            val sound = Gdx.audio.newSound(Gdx.files.internal("sound/$fileName"))
            assets[fileName] = sound
        } catch (e: NullPointerException) {
            throw ResourceNotFoundException("Could not find file sound/$fileName!")
        }
    }

    fun playSound(soundName: String) {
        playSound(soundName, 1.0f)
    }

    fun playSound(soundName: String, pitch: Float) {
        if (!Settings.soundOn) {
            return
        }
        if (assets.containsKey(soundName)) {
            val sound = assets[soundName]
            val id = sound!!.play()
            sound.setPitch(id, pitch)
        } else {
            throw ResourceNotFoundException("File $soundName was not loaded!")
        }
    }

}