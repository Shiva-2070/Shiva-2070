from moviepy.editor import VideoFileClip, clips_array
from moviepy.video.fx.all import rotate
from moviepy.editor import *
def  convert_to_hologram(v):
    v=VideoFileClip(v)
    rv=rotate(v,angle=90)
    iv=rotate(v,angle=180)
    fv=rotate(v,angle=270)
    video1 =v
    video2 = rv
    video3 = iv
    video4 = fv
    pyramid_x = 50
    pyramid_y = 50
    pyramid_width = 600
    pyramid_height = 600
    # video1 = video1.resize(height=pyramid_height)
    video1 = video1.resize(0.3)
    video2 = video2.resize(0.3)
    video3 = video3.resize(0.3)
    video4 = video4.resize(0.3)
    video1 = video1.set_position((pyramid_x+video2.w, 0))
    video2 = video2.set_position((0,video1.h+pyramid_y))
    video3 = video3.set_position((pyramid_x+video2.w, (pyramid_y*2)+video3.h+video2.h))
    video4 = video4.set_position((video1.h+video1.w+(pyramid_x*2),video1.h+pyramid_y))
    # pyramid_clip = ColorClip(size=(pyramid_width, pyramid_height), color=(0, 0, 0)).set_duration(max(video1.duration, video2.duration, video3.duration, video4.duration))
    final = CompositeVideoClip([video1, video2,video3,video4],size=(video1.h*2+pyramid_y*3+video1.w,video1.w+video1.h*2+pyramid_y*3))
    # Set the duration of the final video to the longest duration among the input videos
    # final = final.set_duration(max(video1.duration, video2.duration, video3.duration, video4.duration))
    # final.write_videofile("output.mp4")
    s=final.subclip(0,5)
    s=s.resize(height=final.h*0.3)
    s.ipython_display()
    return final.resize(height=final.h*0.3)