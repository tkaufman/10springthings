require 'java'

class RubyMessenger
  include_class 'org.cinjug.jruby.MessageService'
  
  @@messages = ["Ruby is the shizznit", "JRuby makes me giddy", "Ruby + JRuby + Spring == Ass kickery"]
  
  def getMessage
    index = rand(@@messages.length)
    @@messages[index]
  end
end

# Not essential, but a shortcut
RubyMessenger.new